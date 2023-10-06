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
        console.log(error);
        return new Response("Failed to create user! " + error, { status: 501 });
    }
};

export const GET = async (req) => {
    try {
        await connectToDB();
        const user = await User.find();
        return new Response(JSON.stringify(user), { status: 200 });
    } catch (error) {
        console.log(error);
        return new Response("Failed to get User", { status: 500 });
    }
};