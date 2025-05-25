#!/bin/bash

./gradlew :sushi-core:assembleDebug :sushi-compose:assembleDebug
./gradlew :sushi-core:publishAllPublicationsToZomatoRepository :sushi-compose:publishAllPublicationsToZomatoRepository