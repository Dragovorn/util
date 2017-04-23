#!/usr/bin/env bash

echo "Building and Deploying..."

mvn javadoc:javadoc deploy package shade:shade

echo "Build and deployment complete!"
echo "Deploying Javadocs..."

./javadoc.sh

echo "Javadocs deployed!"