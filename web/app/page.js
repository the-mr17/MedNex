import Image from "next/image";

export default function Home() {
    return (
        <main className="flex flex-col items-center justify-between p-24 relative">
            {/* <Image
                src={
                    "/assets/blue-antibiotic-pill-laboratory-collection-variation-generative-ai.jpg"
                }
                width={1900}
                height={499}
                className=" absolute inset-0 bottom-0 -z-10 mix-blend-multiply
                "
            /> */}
            <div className="full grid grid-flow-row gap-10">
                <div className="flex flex-col text-stone-400 text-lg">
                    <h1 className="text-6xl md:text-9xl text-orange-400">
                        <Image
                            src={"/assets/logo.png"}
                            width={100}
                            height={100}
                            alt="logo"
                        />
                        Welcome to Mednex
                    </h1>
                    <p className=" text-4xl font-extralight text-gray-400">
                        Your one stop solution to medical consultancy
                    </p>
                </div>
                <div>
                    <p className=" text-xl text-gray-300 font-light">
                        Download the mednex app
                    </p>
                    <Image
                        src={"/assets/qrcode.png"}
                        height={200}
                        width={200}
                        className=" p-5"
                    />
                </div>
            </div>
        </main>
    );
}
