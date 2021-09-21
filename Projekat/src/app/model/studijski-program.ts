import { Fakultet } from './fakultet';
export interface StudijskiProgram {
    id?: number,
    naziv: string,
    fakultet: Fakultet
    // nastavnik, fakultt, godinaStudija
}
