import Image from "next/image";

export default function Home() {
    return (
        <main className="flex flex-col items-center justify-between p-24">
            <div className="full grid grid-flow-row gap-10">
                <div className="flex flex-col text-stone-400 text-lg">
                    <h1 className="text-7xl text-orange-400">
                        <Image
                            src={"/assets/logo.png"}
                            width={100}
                            height={100}
                            alt="logo"
                        />
                        Welcome to Mednex
                    </h1>
                    <p className=" text-xl font-light ">
                        Your one stop solution to medical consultancy
                    </p>
                </div>
                <div>Download the mednex app</div>
            </div>
        </main>
    );
}
