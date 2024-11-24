import { CapacitorAutoStart } from 'capacitor-auto-start';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    CapacitorAutoStart.echo({ value: inputValue })
}
