server {
    listen 5010 default_server;

    include /etc/nginx/includes/server_params.conf;

    location / {

        set     $target "{{ .server }}";
        allow   172.30.32.2;
        deny    all;

        proxy_pass $target;
        proxy_set_header X-Ingress-Path {{ .entry }};
        include /etc/nginx/includes/proxy_params.conf;

    }
}