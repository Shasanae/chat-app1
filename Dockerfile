FROM eclipse-temurin:17-jdk

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy mã nguồn vào trong container
COPY . /app

# Cài đặt ứng dụng
RUN ./mvnw clean install

# Chạy ứng dụng Spring Boot với Maven
CMD ["./mvnw", "spring-boot:run"]



