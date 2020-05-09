FROM alpine:3.7 as builder
COPY nginx.conf nginx.conf.tmp
ARG BACKEND="java"
RUN apk add gettext && envsubst '${BACKEND}' < "nginx.conf.tmp" > "nginx.conf"
FROM joelnb/nginx-digest
COPY --from=builder nginx.conf /etc/nginx/conf/nginx.conf
RUN cat /etc/nginx/conf/nginx.conf
EXPOSE 80