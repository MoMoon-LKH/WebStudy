package guestbook.argumentResolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Iterator;

public class HeaderMapArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType() == HeaderInfo.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        HeaderInfo headerInfo = new HeaderInfo();

        Iterator<String> headerNames = nativeWebRequest.getHeaderNames();
        while (headerNames.hasNext()) {
            String headerName = headerNames.next();
            String headerValue = nativeWebRequest.getHeader(headerName);

            headerInfo.put(headerName, headerValue);
        }

        return headerInfo;
    }
}
