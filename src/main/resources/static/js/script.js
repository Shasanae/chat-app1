/**document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    form.addEventListener("submit", function (event) {
        const username = document.getElementById("username").value.trim();
        const password = document.getElementById("password").value.trim();

        if (username === "" || password === "") {
            alert("Vui lòng điền đầy đủ thông tin!");
            event.preventDefault();
        }
    });
});**/

const socket = new SockJS("http://localhost:8180/ws");
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log("Connected: " + frame);

    // Đăng ký nhận tin nhắn từ topic
    stompClient.subscribe("/topic/public", function (message) {
        console.log("Received:", JSON.parse(message.body));
    });

    // Gửi tin nhắn
    stompClient.send("/app/chat", {}, JSON.stringify({
        sender: "user1",
        content: "Hello WebSocket!",
        type: "CHAT"
    }));
});

