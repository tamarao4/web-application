import { TestBed } from '@angular/core/testing';

import { KorisnikPravoPristupaService } from './korisnik-pravo-pristupa.service';

describe('KorisnikPravoPristupaService', () => {
  let service: KorisnikPravoPristupaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KorisnikPravoPristupaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
