import { NaucnaOblast } from './naucna-oblast';
import { Nastavnik } from './nastavnik';
import { TipZvanja } from 'src/app/model/tip-zvanja';
export interface Zvanje {
    id?: number,
    datumIzbora: Date,
    datumPrestanka: Date,
    tipZvanja: TipZvanja,
    nastavnik: Nastavnik,
    naucnaOblast: NaucnaOblast
    // nastavnik, tipZvanja, naucnaOblast
}
