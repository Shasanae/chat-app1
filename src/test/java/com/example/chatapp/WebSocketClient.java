package com.example.chatapp;


import jakarta.websocket.*;

import java.net.URI;
import java.io.IOException;

@ClientEndpoint
public class WebSocketClient {

    private static Session session;

    public static void main(String[] args) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            session = container.connectToServer(WebSocketClient.class, new URI("ws://localhost:8180/websex"));
            System.out.println("✅ Connected to WebSocket server!");

            // Gửi tin nhắn đến server
            sendMessage("{\"sender\":\"A\",\"content\":\"Hello B!\"}");

            // Đợi 5 giây rồi đóng kết nối
            Thread.sleep(5000);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("🔵 WebSocket connection opened");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("📩 Received message: " + message);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        System.out.println("❌ WebSocket connection closed: " + reason);
    }

    @OnError
    public void onError(Throwable throwable) {
        System.out.println("⚠️ WebSocket error: " + throwable.getMessage());
    }

    public static void sendMessage(String message) throws IOException {
        if (session != null && session.isOpen()) {
            session.getBasicRemote().sendText(message);
            System.out.println("📤 Sent message: " + message);
        }
    }
}
