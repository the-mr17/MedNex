import { Schema, model, models } from "mongoose";

const UserSchema = new Schema({
    email: {
        type: String,
        unique: [true, "Email already exists!"],
        required: [true, "Email is required!"],
    },
    fullname: {
        type: String,
        required: [true, "Full name is required!"],
    },
    username: {
        type: String,
        required: [true, "Username is required!"],
        match: [
            /^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$/,
            "Username invalid, it should contain 8-20 alphanumeric characters!",
        ],
        unique: [true, "username already exists!"],
    },
    category: {
        type: String,
        required: [true, "Please select Patient/Doctor"],
    },
    userimage: {
        type: String,
    },
});

const User = models.User || model("User", UserSchema);

export default User;
