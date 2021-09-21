import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KategorijaFormComponent } from './kategorija-form.component';

describe('KategorijaFormComponent', () => {
  let component: KategorijaFormComponent;
  let fixture: ComponentFixture<KategorijaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KategorijaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KategorijaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
