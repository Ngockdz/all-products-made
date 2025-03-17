package lap.lap4;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import java.time.Duration;
import java.util.Locale;

@Configuration
public class MessageConfig<LocaleResolver> implements WebMvcConfigurer {

    // Bean cấu hình nguồn tài nguyên (message source)
    @Bean("messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        
        // Đường dẫn tới các file tài nguyên đa ngôn ngữ (ví dụ: layout.properties, layout_vi.properties)
        ms.setBasenames("classpath:i18n/layout"); // Đảm bảo tên thư mục và tài nguyên đúng
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    // Bean cấu hình locale resolver để xác định ngôn ngữ được sử dụng
    @Bean("localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        
        // Thiết lập đường dẫn của cookie và thời gian sống của cookie (30 ngày)
        localeResolver.setCookiePath("/");
        localeResolver.setCookieMaxAge(Duration.ofDays(30));
        
        // Ngôn ngữ mặc định là Tiếng Việt
        localeResolver.setDefaultLocale(new Locale("vi"));
        
        return (LocaleResolver) localeResolver;
    }

    // Cấu hình interceptor để theo dõi tham số 'lang' trong URL
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        
        // Tham số 'lang' trong URL sẽ giúp thay đổi ngôn ngữ
        interceptor.setParamName("lang");
        
        // Đăng ký interceptor cho phép thay đổi ngôn ngữ
        registry.addInterceptor(interceptor);
    }
}
