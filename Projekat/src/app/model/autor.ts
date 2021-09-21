import { Student } from './student';
import { Nastavnik } from './nastavnik';
import { NeregistrovaniKorisnik } from './neregistrovani-korisnik';
import { NaucniRad } from './naucni-rad';
export interface Autor {
    id?: number
    naucniRad: NaucniRad,
    neregistrovaniKorisnik: NeregistrovaniKorisnik,
    nastavnik: Nastavnik,
    student: Student
}