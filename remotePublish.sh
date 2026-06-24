#!/bin/bash

#./gradlew publishAllPublicationsToMavenCentralRepository --no-configuration-cache


./gradlew :sushi-core:publishAllPublicationsToMavenCentralRepository --no-configuration-cache
./gradlew :sushi-compose:publishAllPublicationsToMavenCentralRepository --no-configuration-cache