# Java Spring Application Monitored with Grafana and Prometheus

## Run Application
```
docker compose up -d

# listing containers
docker ps
```

## Configure Grafana Dashboard
### Add Prometheus URL
    From Grafana portal, http://grafana:3000, login with default username: admin and password: secret
    Home -> Connections -> Data sources -> Add new data source -> Prometheus 
    - Prometheus server: http://prometheus:9090
    - Save & test
### Add JVM Dashboard
    Home -> Dashboards -> Import
    - Dashboard URL or ID: 4701
    - Load
    - Select Prometheus Data Source
    - Import

    ID 4701 is ID for Micrometer JVM Dashboard
