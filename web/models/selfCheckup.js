import { Schema, model, models } from "mongoose";

// Self checks to be done by patient
const selfCheckupSchema = new Schema({
    fullName: {
        type: String,
        required: [true, "\nFull name is required!"],
    },
    userID: {
        type: Schema.Types.ObjectId,
        required: true,
        ref: "User",
    },
    //Category of problem/symptoms
    problemType: {
        type: String,
    },
    checks: {
        age: { type: Number, required: true, min: 0, max: 100 }, // Age of patient to be given by patient
        height: { type: Number, min: 30, max: 300, default: null }, // Height of patient if known
        weight: { type: Number, min: 30, max: 300, default: null }, // Weight of patient if known
        gender: { type: String, required: true, lowercase: true, trim: true }, // Gender of patient (required)
    },
    // Previous Medication if any
    previousMedication: {
        type: String,
        default: null,
    },
});

const SelfCheckup =
    models.SelfCheckup || model("SelfCheckup", selfCheckupSchema);

export default SelfCheckup;
