#!/usr/bin/env bash
docker tag $1:${2:-latest} docker.io/hygl/$1:${2:-latest}
kubectl create deployment $3 --image=hygl/$1:${2:-latest} --dry-run -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip $3 --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml
echo --- >> deployment.yaml
cat << EOF >> deployment.yaml
apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: $3-ingress
spec:
  backend:
    serviceName: $3
    servicePort: 8080
EOF
