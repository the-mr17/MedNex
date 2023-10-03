import User from "@/models/user";
import { connectToDB } from "@/utils/database";

export const GET = async (req, { params }) => {
    try {
        await connectToDB();
        const user = await User.find({ creator: params.id });
        return new Response(JSON.stringify(user), { status: 200 });
    } catch (error) {
        return new Response("Failed to get User", { status: 500 });
    }
};
export const PUT = async (req) => {};
export const DELETE = async (req) => {};
