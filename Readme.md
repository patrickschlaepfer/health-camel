# Guerir

guérir {verb}: to cure · to recover · to treat · to heal · to remedy · to care for

It's the evolution of the first project, which was based on Springboot and camel.
In fact one doesn't need springboot, camel can boot by itself.

But it's insipired by

http://de.slideshare.net/davsclaus/riga-dev-day-2016-microservices-with-apache-camel-fabric8-on-kubernetes

or

https://youtu.be/ouJ3SQHnQ6I

was thinking to adapt it. Just having a plain Camel implementation.

## Requirements

I suggest using the vagrant fabric8 image.

* Java 8
* Maven
* Vagrant
* fabric8
 

## Fabric8 and Openshift

https://github.com/fabric8io/fabric8-installer/tree/master/vagrant/openshift

The easiest way to install fabric8 is to use a vagrant file.

https://github.com/fabric8io/fabric8-installer

### Windows Install

https://blog.openshift.com/running-openshift-origin-on-windows/

```
vagrant plugin install vagrant-hostmanager
```


```
 Please be patient!
==> default: --------------------------------------------------------------
==> default:
==> default: Now might be a good time to setup your host machine to work with OpenShift
==> default:
==> default: * Download a recent release of the binaries and add them to your PATH:
==> default:
==> default:    https://github.com/openshift/origin/releases/
==> default:
==> default: * Set the following environment variables (example is in Unix style, use 'set' for Windows):
==> default:
==> default:    export KUBERNETES_DOMAIN=vagrant.f8
==> default:    export DOCKER_HOST=tcp://vagrant.f8:2375
==> default:
==> default: Now login to OpenShift via this command:
==> default:
==> default:    oc login https://172.28.128.4:8443
==> default:
==> default: Then enter admin/admin for user/password.
==> default:
==> default: Over time your token may expire and you will need to reauthenticate via:
==> default:
==> default:    oc login
==> default:
==> default: Now to see the status of the system:
==> default:
==> default:    oc get pods
==> default:
==> default: or you can watch from the command line via one of these commands:
==> default:
==> default:    watch oc get pods
==> default:    oc get pods --watch
```

#### Set environment variables on Windows

Add the two following env variables.

```
set KUBERNETES_DOMAIN=vagrant.f8
set export DOCKER_HOST=tcp://vagrant.f8:2375
```


