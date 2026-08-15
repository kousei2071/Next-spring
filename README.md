# Next.js × Spring Boot

```
Next-spring/
├── backend/    Spring Boot 4.1（Java 17, ポート 8080）
└── frontend/   Next.js 16（React 19, ポート 3000）
```

## 起動

**1. API**

```bash
cd backend
./mvnw spring-boot:run
```

確認: http://localhost:8080/api/hello

**2. UI**

```bash
cd frontend
npm run dev
```

確認: http://localhost:3000

## これから作るもの

ログイン機能は削除済みです。手順はチャットの Step 1 から自分で実装してください。
