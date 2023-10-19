import selfCheckup from "@/models/selfCheckup";
import { connectToDB } from "@/utils/database"; //function for connecting to mongodb

// Handle Get request for selfCheckup with the ObjectId of the selfCheckup passed into the params
// e.g.- {{base_url}}/api/selfCheckups/12345  Method: GET
export const GET = async (request, { params }) => {
    try {
        await connectToDB();
        const newSelfCheckup = await selfCheckup.findById(params.id); //Get selfCheckup by id
        request.headers.set("Cache-Control", "no-cache"); // Do not cache the fetched data
        request.revalidateSeconds = 30;

        return new Response(JSON.stringify(newSelfCheckup), {
            status: 200,
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        console.log(error);
        const err = {
            message: "Failed to get selfCheckup", //generic error message
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

// Handle PUT requests for selfCheckup with the ObjectId of the selfCheckup passed into the params
// e.g.-
//
// {{base_url}}/api/selfCheckups/12345
// Method: PUT
// Body:{
//     "text":"updated text"
// }
export const PUT = async (req, { params }) => {
    try {
        await connectToDB();

        // Get the updated selfCheckup info from the request body
        const updates = await req.json();
        // Find the selfCheckup by Id and update the data of the selfCheckup with the body of the request
        const newSelfCheckup = await selfCheckup.findByIdAndUpdate(
            params.id,
            updates,
            {
                new: true,
            }
        );

        return new Response(JSON.stringify(newSelfCheckup), {
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        const err = {
            message: "Failed to update selfCheckup", //generic error message
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

// Handle DELETE request for selfCheckup with the ObjectId of the selfCheckup passed into the params
// e.g.- {{base_url}}/api/selfCheckups/12345  Method: DELETE
export const DELETE = async (req, { params }) => {
    try {
        await connectToDB();
        // Find selfCheckup with the Id in mongodb and delete the selfCheckup
        const selfCheckup = await selfCheckup.findByIdAndDelete(params.id);
        return new Response(`selfCheckup ${params.id} was deleted`, {
            status: 200,
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        const err = {
            message: "Failed to Delete selfCheckup", //Generic error Message
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
