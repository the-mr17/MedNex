import selfCheckup from "@/models/selfCheckup";
import { connectToDB } from "@/utils/database"; //Function for connecting to Db

export const POST = async (request) => {
    const {
        fullName,
        userID,
        problemType,
        checks: { age, height, weight, gender },
        previousMedication,
    } = await request.json(); // get the data from the body of the request

    try {
        await connectToDB();
        const newSelfCheckup = new selfCheckup({
            fullName,
            userID,
            problemType,
            checks: { age, height, weight, gender },
            previousMedication,
        });

        await newSelfCheckup.save();

        return new Response(JSON.stringify(newSelfCheckup), {
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
