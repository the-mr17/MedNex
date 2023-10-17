import prescription from "@/models/prescription";
import { connectToDB } from "@/utils/database"; //Function for connecting to Db

export const POST = async (request) => {
    const { patientId, doctorId, doctorName, medication, tests } =
        await request.json(); // get the data from the body of the request

    try {
        await connectToDB();
        const newPrescription = new prescription({
            patientId,
            doctorId,
            doctorName: doctorName,
            medication: medication,
            tests: tests,
        });

        await newPrescription.save();

        return new Response(JSON.stringify(newPrescription), {
            status: 201,
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        const err = {
            message: "Failed to create Post", //Generic error message
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
