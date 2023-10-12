import React from "react";
import Link from "next/link";
import Image from "next/image";

const NotFound = () => {
    return (
        <>
            <div className="flex flex-col w-full h-full justify-center align-middle items-center p-20 gap-3 relative ">
                {/* <Image
                    src="assets/error.svg"
                    width={500}
                    height={300}
                    className="absolute inset-0 -z-10"
                /> */}
                <h1 className=" text-9xl font-extrabold text-zinc-100 tracking-widest">
                    404
                </h1>
                <p className=" text-3xl font-light text-zinc-400">
                    Page Not Found
                </p>
                <Link
                    href="/"
                    className="font-extralight text-lg text-blue-400">
                    Return Home
                </Link>
            </div>
        </>
    );
};

export default NotFound;
