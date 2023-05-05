create database restos;

/////////////////

 create table type (
    id int auto_increment primary key,
    nom varchar(50) not null
    );

create table prix(
    id int auto_increment primary key,
    categorie varchar(10) not null);

create table arrondissement(
    id int auto_increment primary key,
    numero int
);

create table restaurant(
    id int auto_increment primary key,
    nom varchar(50) not null,
    adresse varchar(500),
    tel varchar(20),
    maps varchar(500),
    id_type int,
    id_prix int,
    foreign key (id_type) references type(id),
    foreign key (id_prix) references prix(id),
    foreign key (id_arrondissement) references arrondissement(id));

/////////////////

insert into type (nom) values ('francais'), ('japonais'), ('coreen'), ('chinois'), ('italien'), ('indien'), ('libanais'), ('iranien'), ('grec');

insert into prix (categorie) values ('e'), ('ee'), ('eee');

insert into restaurant (nom, adresse, tel, id_type, id_prix, maps)
values (
    'Dandy Kitchen',
    '86 rue Saint Denis Dandy Hotel & Kitchen, 75001 Paris France',
    '+33 1 44 82 63 18',
    1,
    3,
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2624.7841771560306!2d2.3470223762702416!3d48.86232577133262!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e66fcc64c7dee7%3A0x98d64655c73726ae!2sDandy%20Kitchen!5e0!3m2!1sfr!2sfr!4v1681399047366!5m2!1sfr!2sfr"
),
(
    'Sushi Man',
    '31 rue des Belles Feuilles, 75116 Paris France',
    '+33 1 47 27 28 82',
    2,
    2,
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d20340.256892704754!2d2.2472793749451223!3d48.866881950842945!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e66ff9db26ec55%3A0x5b4b23ec52a8a7fd!2sSushiman!5e0!3m2!1sen!2sfr!4v1681400661981!5m2!1sen!2sfr"
),
(
    'Go Oun',
    '14 rue Therese, 75001 Paris France',
    '+33 1 40 15 64 43',
    3,
    2,
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2624.573427212054!2d2.332771376270532!3d48.86634417133323!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e66f485010c0fd%3A0x16a65941eae10a2c!2sGo%20Oun!5e0!3m2!1sen!2sfr!4v1681400713843!5m2!1sen!2sfr"
),
(
    'Mian Fan',
    '124 boulevard du Montparnasse, 75014 Paris France',
    '+33 1 56 54 01 55',
    4,
    2,
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10503.554327090273!2d2.3122344871582032!3d48.84126390000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e671c8ad9c1cdd%3A0x8fd46648389a97c4!2sMian%20Fan!5e0!3m2!1sen!2sfr!4v1681400799369!5m2!1sen!2sfr"

),
(
    'Nell Arte',
    '58 Rue Marguerite De Rochechouart, 75009 Paris France',
    '+33 6 29 47 15 88',
    5,
    2,
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2623.8230475962473!2d2.3439240762714224!3d48.880649771335186!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e66f0e94a2d2eb%3A0x11a81dca9bb20353!2sNell&#39;Arte!5e0!3m2!1sen!2sfr!4v1681400835419!5m2!1sen!2sfr"
),
(
    'New Jawad Longchamp',
    '30 rue de Longchamp, 75116 Paris France',
    '+33 1 47 27 24 14',
    6,
    3,
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2624.6372136834148!2d2.287560076270453!3d48.865127971333045!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e66fe52128b4cf%3A0x38b952761283d0a0!2sNew%20Jawad%20Longchamp!5e0!3m2!1sen!2sfr!4v1681400865515!5m2!1sen!2sfr"
),
(
    'AlKaram',
    '15 Rue Ferdinand Fabre, 75015 Paris France',
    '+33 1 45 33 00 00',
    7,
    3,
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2626.034602034899!2d2.294589376268827!3d48.83847867132958!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e6701569981925%3A0x8f34525928cc3baa!2sAlKaram%20Paris%2075015!5e0!3m2!1sen!2sfr!4v1681400898474!5m2!1sen!2sfr"
),
(
    'Shabestan',
    '5 rue du Commandant Riviere, 75008 Paris France',
    '+33 1 45 63 95 68',
    8,
    2,
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2624.2410806714834!2d2.306759276270915!3d48.872680571334115!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e66fc67d5d7039%3A0xa62af8d3de88d2fb!2sShabestan!5e0!3m2!1sen!2sfr!4v1681400932740!5m2!1sen!2sfr"
),
(
    'Karavaki Au Jardin Du Luxembourg',
    '7 rue Gay Lussac metro Luxembourg, 75005 Paris France',
    '+33 9 53 38 88 70',
    9,
    1,
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2625.615565235642!2d2.338581876269328!3d48.84647117133056!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e671a940899879%3A0xb6bd6dc07b912480!2sKaravaki%20au%20Jardin%20de%20Luxembourg!5e0!3m2!1sen!2sfr!4v1681400966963!5m2!1sen!2sfr"
);

//////////////////////////////////////////

create table theme(
    id int auto_increment primary key,
    nom varchar(50)
);

create table avis(
    id int auto_increment primary key,
    surnom varchar(50),
    texte varchar(5000),
    id_restaurant int,
    id_theme int,
    foreign key (id_restaurant) references restaurant(id),
    foreign key (id_theme) references theme(id)
);

insert into theme (nom) values ('service'), ('accueil'), ('reservation');