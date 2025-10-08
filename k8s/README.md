# Kubernetes Manifests para Basic Spring Batch

Este directorio contiene los manifiestos de Kubernetes para desplegar y ejecutar la aplicación Spring Batch.

## 📁 Estructura de Archivos

```
k8s/
├── 01-namespace.yaml          # Namespace para la aplicación
├── 02-configmap.yaml          # Configuración de la aplicación
├── 03-deployment.yaml         # Deployment para la aplicación
├── 04-job.yaml               # Jobs para ejecución manual
├── 05-cronjob.yaml           # CronJobs para ejecución programada
├── kubectl-commands.sh       # Comandos útiles
└── README.md                 # Este archivo
```

## 🚀 Despliegue Rápido

### 1. Aplicar todos los manifiestos:
```bash
kubectl apply -f k8s/
```

### 2. Verificar el despliegue:
```bash
kubectl get all -n spring-batch
```

### 3. Ver logs:
```bash
kubectl logs -f deployment/basic-spring-batch -n spring-batch
```

## 📋 Recursos Creados

### Namespace
- **Nombre**: `spring-batch`
- **Propósito**: Aislar los recursos de la aplicación

### ConfigMap
- **Nombre**: `spring-batch-config`
- **Contenido**: Configuración de Spring Batch, H2, y parámetros por defecto

### Deployment
- **Nombre**: `basic-spring-batch`
- **Réplicas**: 1
- **Recursos**: 256Mi-512Mi RAM, 250m-500m CPU
- **Propósito**: Mantener la aplicación corriendo

### Jobs
- **spring-batch-greeting-job**: Job con parámetros por defecto
- **spring-batch-custom-job**: Job con parámetros personalizados

### CronJobs
- **spring-batch-scheduled-greeting**: Ejecución cada 6 horas
- **spring-batch-daily-greeting**: Ejecución diaria a las 9:00 AM

## ⚙️ Configuración

### Variables de Entorno
- `JAVA_OPTS`: Configuración de memoria Java (-Xmx512m -Xms256m)
- `SPRING_PROFILES_ACTIVE`: Perfil activo (k8s)

### Recursos Asignados
- **Requests**: 256Mi RAM, 250m CPU
- **Limits**: 512Mi RAM, 500m CPU

## 🔧 Comandos Útiles

### Ver estado de los recursos:
```bash
kubectl get all -n spring-batch
```

### Ver logs de un Job:
```bash
kubectl logs job/spring-batch-greeting-job -n spring-batch
```

### Ejecutar un Job manual:
```bash
kubectl create job --from=job/spring-batch-greeting-job manual-job -n spring-batch
```

### Ver CronJobs:
```bash
kubectl get cronjobs -n spring-batch
```

### Describir un recurso:
```bash
kubectl describe deployment basic-spring-batch -n spring-batch
```

## 🗑️ Limpieza

Para eliminar todos los recursos:
```bash
kubectl delete namespace spring-batch
```

## 📝 Notas Importantes

1. **Imagen Docker**: Asegúrate de que la imagen `basic-spring-batch:1.0.0` esté disponible en tu cluster
2. **Configuración**: Los parámetros se pueden modificar en el ConfigMap
3. **Programación**: Los CronJobs se pueden ajustar modificando el campo `schedule`
4. **Recursos**: Ajusta los límites según las necesidades de tu cluster
5. **Logs**: Los Jobs tienen TTL de 5 minutos para limpieza automática

## 🔍 Troubleshooting

### Si el Job falla:
```bash
kubectl describe job spring-batch-greeting-job -n spring-batch
kubectl logs job/spring-batch-greeting-job -n spring-batch
```

### Si el Deployment no se inicia:
```bash
kubectl describe deployment basic-spring-batch -n spring-batch
kubectl get events -n spring-batch
```

### Si la imagen no se encuentra:
```bash
kubectl get pods -n spring-batch
kubectl describe pod <pod-name> -n spring-batch
```
