// 페이지 로드 시 애니메이션
window.addEventListener('DOMContentLoaded', function() {
    console.log('🎉 JSP 페이지 로드 완료!');
    console.log('📊 사용자 정보:', '${user.name}');

    // 간단한 페이드인 효과
    document.querySelector('.container').style.opacity = '0';
    document.querySelector('.container').style.transform = 'translateY(20px)';

    setTimeout(function() {
        document.querySelector('.container').style.transition = 'all 0.5s ease';
        document.querySelector('.container').style.opacity = '1';
        document.querySelector('.container').style.transform = 'translateY(0)';
    }, 100);
});