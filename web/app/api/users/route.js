import User from "@/models/user";
import { connectToDB } from "@/utils/database";

export const POST = async (req) => {
    const { email, fullname, username, category, userimage } = await req.json();

    try {
        await connectToDB();
        const newUser = new User({
            email: email,
            fullname: fullname,
            username: username,
            category: category,
            userimage: userimage,
        });
        await newUser.save();
        return new Response(JSON.stringify(newUser), { status: 201 });
    } catch (error) {
        let message = "Failed to create user";

        if (error.code == 11000) {
            message = Object.keys(error.keyValue)[0] + " already exists!";
        } else if (error.name == "ValidationError") {
            for (const field in error.errors) {
                message += ` ${field}: ${error.errors[field].message}`;
            }
        }
        const err = {
            message: message,
            errorDetails: error.message,
            fullError: error,
        };
        console.log(message);
        return new Response(JSON.stringify(err), { status: 500 });
    }
};

export const GET = async (req) => {
    try {
        await connectToDB();
        const user = await User.find();
        return new Response(JSON.stringify(user), { status: 200 });
    } catch (error) {
        console.log(error.message);
        return new Response("Failed to get Users", { status: 500 });
    }
};
