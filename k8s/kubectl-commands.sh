#!/bin/bash

# Script con comandos útiles para gestionar la aplicación Spring Batch en Kubernetes

echo "=== Comandos para gestionar Spring Batch en Kubernetes ==="

echo ""
echo "1. Aplicar todos los manifiestos:"
echo "kubectl apply -f k8s/"

echo ""
echo "2. Verificar el estado de los recursos:"
echo "kubectl get all -n spring-batch"

echo ""
echo "3. Ver logs del deployment:"
echo "kubectl logs -f deployment/basic-spring-batch -n spring-batch"

echo ""
echo "4. Ejecutar un Job manual:"
echo "kubectl create job --from=job/spring-batch-greeting-job manual-greeting-job -n spring-batch"

echo ""
echo "5. Ver logs de un Job:"
echo "kubectl logs job/spring-batch-greeting-job -n spring-batch"

echo ""
echo "6. Ver estado de los CronJobs:"
echo "kubectl get cronjobs -n spring-batch"

echo ""
echo "7. Ver Jobs ejecutados:"
echo "kubectl get jobs -n spring-batch"

echo ""
echo "8. Eliminar todos los recursos:"
echo "kubectl delete namespace spring-batch"

echo ""
echo "9. Port-forward para acceso local (si hay service):"
echo "kubectl port-forward service/basic-spring-batch 8080:8080 -n spring-batch"

echo ""
echo "10. Describir un recurso específico:"
echo "kubectl describe deployment basic-spring-batch -n spring-batch"
echo "kubectl describe job spring-batch-greeting-job -n spring-batch"
echo "kubectl describe cronjob spring-batch-scheduled-greeting -n spring-batch"
