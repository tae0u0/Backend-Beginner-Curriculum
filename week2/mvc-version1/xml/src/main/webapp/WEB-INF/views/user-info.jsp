<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user-info.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h1>🚀 ${pageTitle}</h1>
        <div class="subtitle">내장 톰캣 + 서블릿 + JSP 예제</div>
    </div>

    <div class="content">
        <div class="user-card">
            <h2 style="color: #4CAF50; margin-bottom: 20px;">
                <span class="emoji">👤</span>사용자 정보
            </h2>

            <div class="user-info">
                <div class="info-item">
                    <span class="info-label">ID:</span>
                    <span class="info-value">${user.id}</span>
                </div>

                <div class="info-item">
                    <span class="info-label">이름:</span>
                    <span class="info-value">${user.name}</span>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/user-info.js"></script>
</body>
</html>