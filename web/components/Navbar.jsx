import Image from "next/image";
import Link from "next/link";

function classNames(...classes) {
    return classes.filter(Boolean).join(" ");
}

export default function Example() {
    return (
        <nav className=" sticky bg-orange-300 inset-x-0 p-3 m-0 top-0 flex justify-center font-semibold text-neutral-800">
            <div className=" max-w-7xl w-full flex justify-between align-middle">
                <div className="flex gap-3">
                    <Image
                        src={"/assets/logo.png"}
                        width={25}
                        height={25}
                        className=""
                        alt="logo"
                    />
                    <h1 className=" text-xl ">MedNex</h1>
                </div>
                <div className="flex justify-around align-middle w-5/12">
                    <Link href={"/"}>Downloads</Link>
                    <Link
                        href={"https://github.com/theMr17/MedNex"}
                        target="blank">
                        Github
                    </Link>
                    <Link href={"/team"}>Team</Link>
                </div>
            </div>
        </nav>
    );
}
