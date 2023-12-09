export default function Home() {
  const role = localStorage.getItem("role");

  return (
    <>
      This is the homepage
      {role === "USER" && <p>hello regular user</p>}
      {role === "ADMIN" && <p>How you doin'?</p>}
    </>
  );
}
