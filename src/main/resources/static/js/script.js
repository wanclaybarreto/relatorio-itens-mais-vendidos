let inputsDate = document.querySelectorAll(".relatorioBox form .dates input");

if (inputsDate) {
    inputsDate.forEach((ipt) => {
        ipt.value = "";
    });
}