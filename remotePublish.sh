#!/bin/bash
set -euo pipefail

#./gradlew publishAllPublicationsToZomatoRepository --no-configuration-cache


./gradlew :sushi-core:publishAllPublicationsToZomatoRepository --no-configuration-cache
./gradlew :sushi-compose:publishAndroidReleasePublicationToZomatoRepository --no-configuration-cache
