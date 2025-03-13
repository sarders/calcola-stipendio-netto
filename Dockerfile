# Use an official Node.js runtime as a parent image
FROM node:14

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install dependencies
RUN npm install

# Expose port 8080 for the app to run
EXPOSE 8080

# Define the command to run your app
CMD ["npm", "start"]
