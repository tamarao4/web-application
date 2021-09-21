import { Drzava } from 'src/app/model/drzava';
export interface Mesto {
    id?: number,
    naziv: string,
    drzava: Drzava
}
