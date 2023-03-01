server {
    listen 5010 default_server;

    include /etc/nginx/includes/server_params.conf;

    location / {
        allow   172.30.32.2;
        

        proxy_pass backend;
        proxy_set_header X-Ingress-Path {{ .entry }};
        include /etc/nginx/includes/proxy_params.conf;
    }
}