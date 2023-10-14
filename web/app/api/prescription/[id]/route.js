import prescription from "@/models/prescription";
import { connectToDB } from "@/utils/database"; //function for connecting to mongodb

// Handle Get request for prescription with the ObjectId of the prescription passed into the params
// e.g.- {{base_url}}/api/prescriptions/12345  Method: GET
export const GET = async (request, { params }) => {
    try {
        await connectToDB();
        const newPrescription = await prescription.findById(params.id); //Get prescription by id
        request.headers.set("Cache-Control", "no-cache"); // Do not cache the fetched data
        request.revalidateSeconds = 30;

        return new Response(JSON.stringify(newPrescription), {
            status: 200,
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        console.log(error);
        const err = {
            message: "Failed to get prescription", //generic error message
            error,
        };
        return new Response(JSON.stringify(err), {
            status: 500,
            headers: {
                "Content-Type": "application/json",
            },
        });
    }
};

// Handle PUT requests for prescription with the ObjectId of the prescription passed into the params
// e.g.-
//
// {{base_url}}/api/prescriptions/12345
// Method: PUT
// Body:{
//     "text":"updated text"
// }
export const PUT = async (req, { params }) => {
    try {
        await connectToDB();

        // Get the updated prescription info from the request body
        const updates = await req.json();
        // Find the prescription by Id and update the data of the prescription with the body of the request
        const newPrescription = await prescription.findByIdAndUpdate(
            params.id,
            updates,
            {
                new: true,
            }
        );

        return new Response(JSON.stringify(newPrescription), {
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        const err = {
            message: "Failed to update prescription", //generic error message
            error,
        };
        return new Response(JSON.stringify(err), {
            status: 500,
            headers: {
                "Content-Type": "application/json",
            },
        });
    }
};

// Handle DELETE request for prescription with the ObjectId of the prescription passed into the params
// e.g.- {{base_url}}/api/prescriptions/12345  Method: DELETE
export const DELETE = async (req, { params }) => {
    try {
        await connectToDB();
        // Find prescription with the Id in mongodb and delete the prescription
        const prescription = await prescription.findByIdAndDelete(params.id);
        return new Response(`prescription ${params.id} was deleted`, {
            status: 200,
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        const err = {
            message: "Failed to Delete prescription", //Generic error Message
            error,
        };
        return new Response(JSON.stringify(err), {
            status: 500,
            headers: {
                "Content-Type": "application/json",
            },
        });
    }
};
