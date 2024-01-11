FROM node:18.13

# Install Angular CLI globally
RUN npm install -g @angular/cli

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install --legacy-peer-deps

COPY . .

RUN ng build --configuration production

EXPOSE 80

CMD ["npm", "start"]
