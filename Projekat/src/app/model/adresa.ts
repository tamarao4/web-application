import { Mesto } from 'src/app/model/mesto';
export interface Adresa {
    id?: number,
    ulica: String,
    broj: number,
    mesto: Mesto
    // fakultet: Fakultet,
    // nastavnik: Nastavnik,
    // student: Student,
    // univerzitet: Univerzitet
}
