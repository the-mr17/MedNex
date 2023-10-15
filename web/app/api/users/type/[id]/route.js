import User from "@/models/user";
import { connectToDB } from "@/utils/database";

// Handle Get request for user with the username of the user passed into the params.id
// e.g.- {{base_url}}/api/users/12345  Method: GET
export const GET = async (request, { params }) => {
    try {
        await connectToDB();
        const user = await User.findOne({ category: params.id }); //find one object with the ID parameter
        request.headers.set("Cache-Control", "no-cache");
        request.revalidateSeconds = 30;
        return new Response(JSON.stringify(user), {
            status: 200,
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        const err = {
            message: "Failed to get User",
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};
