FROM debian:bullseye-slim

# can be passed during Docker build as build time environment for github branch to pickup configuration from.
ARG spring_config_label

# can be passed during Docker build as build time environment for spring profiles active 
ARG active_profile

# can be passed during Docker build as build time environment for config server URL 
ARG spring_config_url

# can be passed during Docker build as build time environment for glowroot
ARG is_glowroot

# can be passed during Docker build as build time environment for artifactory URL
ARG artifactory_url

ARG loader_path

# can be passed during Docker build as build time environment for github branch to pickup configuration from.
ARG container_user=mosip
ARG container_user_group=mosip
ARG container_user_uid=1001
ARG container_user_gid=1001

# can be passed during Docker build as build time environment for label related addition to docker.
ARG SOURCE
ARG COMMIT_HASH
ARG COMMIT_ID
ARG BUILD_TIME

# environment variable to pass active profile such as DEV, QA etc at docker runtime
ENV active_profile_env=${active_profile}

# environment variable to pass github branch to pickup configuration from, at docker runtime
ENV spring_config_label_env=${spring_config_label}

# environment variable to pass spring configuration url, at docker runtime
ENV spring_config_url_env=${spring_config_url}

# environment variable to pass glowroot, at docker runtime
ENV is_glowroot_env=${is_glowroot}

# environment variable to pass artifactory url, at docker runtime
ENV artifactory_url_env=${artifactory_url}

# environment variable to pass iam_adapter url, at docker runtime
ENV iam_adapter_url_env=${iam_adapter_url}

# environment variable to pass to set workdir.
ENV work_dir=/home/${container_user}

# environment variable to pass for setting loader path
ENV loader_path_env=${work_dir}/additional_jars/

# Labels can be added to the image for metadata purposes such as source, commit hash, commit ID, and build time.
LABEL source=${SOURCE}
LABEL commit_hash=${COMMIT_HASH}
LABEL commit_id=${COMMIT_ID}
LABEL build_time=${BUILD_TIME}

# Copy the native executable from the build stage
COPY  ./target/graalvm-springboot-example ${work_dir}/graalvm-springboot-example

WORKDIR ${work_dir}

# Install necessary runtime dependencies
RUN apt-get update && apt-get install -y --no-install-recommends \
    libc6 libstdc++6 zlib1g && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* \
    chmod +x /app/graalvm-springboot-example

# Expose the port your application uses (if applicable)
EXPOSE 8081

# Command to run the native application
# Set default command with arguments
#CMD ["./graalvm-springboot-example", "-verbose", "--debug", "-Dspring.profiles.active="${active_profile_env}"", "-Dspring.cloud.config.uri="${spring_config_url_env}"", "-Dspring.cloud.config.label="${spring_config_label_env}"", "--gc=serial"]

# Set the CMD to run the application
#CMD pwd ; \
#    ./graalvm-springboot-example -verbose --debug -Dspring.profiles.active="${active_profile_env}" -Dspring.cloud.config.uri="${spring_config_url_env}" -Dspring.cloud.config.label="${spring_config_label_env}" --gc=serial;

# Debugging: Check present working directory and list files
CMD pwd && ls -l && ./graalvm-springboot-example -verbose --debug \
     -Dspring.profiles.active=${active_profile_env} \
     -Dspring.cloud.config.uri=${spring_config_url_env} \
     -Dspring.cloud.config.label=${spring_config_label_env} \
     --gc=serial
