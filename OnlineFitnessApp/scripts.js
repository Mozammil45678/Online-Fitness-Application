document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("loginForm");
    if (loginForm) {
        loginForm.addEventListener("submit", (e) => {
            e.preventDefault();
            const email = document.getElementById("email");
            const password = document.getElementById("password");

            if (!email.checkValidity()) {
                email.classList.add("is-invalid");
            } else {
                email.classList.remove("is-invalid");
            }

            if (!password.value) {
                password.classList.add("is-invalid");
            } else {
                password.classList.remove("is-invalid");
            }

            if (email.checkValidity() && password.value) {
                alert("Login Successful");
            }
        });
    }
});
