import { ObjavljeniNaucniRad } from './objavljeni-naucni-rad';
import { Adresa } from 'src/app/model/adresa';
export interface Nastavnik {
    id?: number,
    ime: string,
    biografija: string,
    jmbg: string,
    adresa: Adresa,
    // autor
    objavljeniNaucniRad: ObjavljeniNaucniRad
}
