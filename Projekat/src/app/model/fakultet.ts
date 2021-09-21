import { Univerzitet } from './univerzitet';
import { Nastavnik } from 'src/app/model/nastavnik';
import { Adresa } from "./adresa";

export interface Fakultet {
    id?: number,
    naziv: string,
    telefon: string,
    email: string,
    opis: string,
    adresa: Adresa,
    nastavnik: Nastavnik,
    univerzitet: Univerzitet
    // veze: univerzitet, adresa, dekan, studijski program
}
