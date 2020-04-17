FROM nginx
ARG BACKEND="java"
COPY nginx.conf /etc/nginx/nginx.conf.tmp
COPY htpasswd conf/htpasswd
RUN envsubst '${BACKEND}' < "/etc/nginx/nginx.conf.tmp" > "/etc/nginx/nginx.conf"
RUN nginx -t
EXPOSE 80