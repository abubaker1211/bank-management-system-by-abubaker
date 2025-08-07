# Use official Tomcat image
FROM tomcat:9.0

# Remove default apps (optional)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR file into Tomcat's webapps directory
COPY target/bank-management-system.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080
