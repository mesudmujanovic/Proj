# 1. Uzimamo zvaničnu Node.js sliku (verzija 18, na bazi Alpine Linuxa)
#    Alpine je mali Linux (svega 5MB), što će naš image biti manji.
FROM node:18-alpine

# 2. Postavljamo radni folder unutar kontejnera na /app
#    Sve naredne komande će se izvršavati u tom folderu.
WORKDIR /app

# 3. Kopiramo samo package.json i package-lock.json (ako postoji) u kontejner.
#    Ovo radimo odvojeno da bi Docker keširao instalaciju npm paketa.
#    Ako se package.json ne promijeni, Docker neće ponovo instalirati sve pakete.
COPY package*.json ./

# 4. Instaliramo sve potrebne npm pakete unutar kontejnera.
#    npm ci je čišća i brža verzija za produkciju, ali za lokalno možemo i npm install.
#    Ovdje ćemo koristiti npm install jer je jednostavnije.
RUN npm ci

# 5. Kopiramo sav ostali kod (TypeScript, komponente, stilove, angular.json, itd.)
COPY . .

# 6. Izlažemo port 4200 (Angularov podrazumijevani port za ng serve)
EXPOSE 4200

# 7. Komanda koja se pokreće kad se kontejner pokrene:
#    ng serve --host 0.0.0.0 --poll 2000
#    --host 0.0.0.0 - dozvoljava pristup izvan kontejnera (da možeš otvoriti u browseru)
#    --poll 2000 - u nekim okruženjima (Docker na Windows/Mac) file change ne radi automatski,
#                  pa polling pomaže. Ako ne radi bez toga, dodaj. Za početak stavi.
CMD ["npm", "run", "start", "--", "--host", "0.0.0.0", "--poll", "2000", "--allowed-hosts", "true"]