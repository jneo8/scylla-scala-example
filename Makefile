##@ Show
tree:  ## Show repo tree. 
	tree -I target

##@ build

build:  ## Run sbt assembly
	sbt assembly

##@ run

run:  ## Run spark submit
	spark-submit --master yarn --deploy-mode client --class example.SparkSessionExample target/scala-2.12/scylla-scala.jar

##@ Help

.PHONY: help

help:  ## Display this help
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m<target>\033[0m\n"} /^[a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

.DEFAULT_GOAL := help
